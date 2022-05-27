package com.ahmetbozkan.ehliyetcepte.data.db.usefultopics

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.di.ApplicationScope
import com.ahmetbozkan.ehliyetcepte.domain.usecase.vehiclegauges.GetParsedVehicleGaugesListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [VehicleGauge::class], version = 1, exportSchema = false)
abstract class UsefulTopicsDatabase : RoomDatabase() {

    abstract fun usefulTopicsDao(): UsefulTopicsDao

    class Callback @Inject constructor(
        private val database: Provider<UsefulTopicsDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope,
        private val getParsedVehicleGaugesListUseCase: GetParsedVehicleGaugesListUseCase
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().usefulTopicsDao()

            val vehicleGauges: List<VehicleGauge> = getParsedVehicleGaugesListUseCase.vehicleGauges

            applicationScope.launch {
                dao.insert(*vehicleGauges.toTypedArray())
            }

        }

    }

}
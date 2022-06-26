package com.ahmetbozkan.ehliyetcepte.data.db.usefultopics

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.*
import com.ahmetbozkan.ehliyetcepte.di.ApplicationScope
import com.ahmetbozkan.ehliyetcepte.domain.usecase.cityplates.GetParsedCityPlateListUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.examtips.GetParsedExamTipsListUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.faq.GetParsedFAQListUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.trafficsigns.GetParsedTrafficSignListUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.vehiclegauges.GetParsedVehicleGaugesListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [VehicleGauge::class, TrafficSign::class, ExamTip::class, CityPlate::class, FAQ::class],
    version = 1,
    exportSchema = false
)
abstract class UsefulTopicsDatabase : RoomDatabase() {

    abstract fun usefulTopicsDao(): UsefulTopicsDao

    class Callback @Inject constructor(
        private val database: Provider<UsefulTopicsDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope,
        private val getParsedVehicleGaugesListUseCase: GetParsedVehicleGaugesListUseCase,
        private val getParsedTrafficSignListUseCase: GetParsedTrafficSignListUseCase,
        private val getParsedExamTipsListUseCase: GetParsedExamTipsListUseCase,
        private val getParsedCityPlateListUseCase: GetParsedCityPlateListUseCase,
        private val getParsedFAQListUseCase: GetParsedFAQListUseCase
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().usefulTopicsDao()

            val vehicleGauges: List<VehicleGauge> = getParsedVehicleGaugesListUseCase.vehicleGauges
            val trafficSigns: List<TrafficSign> = getParsedTrafficSignListUseCase.trafficSigns
            val examTips: List<ExamTip> = getParsedExamTipsListUseCase.examTips
            val cityPlates: List<CityPlate> = getParsedCityPlateListUseCase.cityPlates
            val faqs: List<FAQ> = getParsedFAQListUseCase.faqs

            applicationScope.launch {
                dao.insert(*vehicleGauges.toTypedArray())
                dao.insert(*trafficSigns.toTypedArray())
                dao.insert(*examTips.toTypedArray())
                dao.insert(*cityPlates.toTypedArray())
                dao.insert(*faqs.toTypedArray())
            }

        }

    }

}
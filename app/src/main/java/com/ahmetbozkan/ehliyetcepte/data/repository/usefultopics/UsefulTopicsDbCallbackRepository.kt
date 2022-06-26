package com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics

import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.*

interface UsefulTopicsDbCallbackRepository {

    /**
     * get VehicleGauges as entity classes from vehicle_gauges.json file to insert Room db
     */
    fun getVehicleGaugesEntities(): List<VehicleGauge>

    /**
     * get TrafficSign as entity classes from traffic_sign.json file to insert Room db
     */
    fun getTrafficSignEntities(): List<TrafficSign>

    /**
     * get ExamTip as entity classes from exam_tips.json file to insert Room db
     */
    fun getExamTipsEntities(): List<ExamTip>

    /**
     * get CityPlate as entity classes from city_plates.json file to insert Room db
     */
    fun getCityPlateEntities(): List<CityPlate>

    /**
     * get Frequently Asked Questions as FAQ entity class from faq.json file to insert Room db
     */
    fun getFrequentlyAskedQuestions(): List<FAQ>

    /**
     * get Traffic Fines as TrafficFine entity class from traffic_fines.json file to insert Room db
     */
    fun getTrafficFines(): List<TrafficFine>
}
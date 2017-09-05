package benbeverly.samplejobsearch.service

import benbeverly.samplejobsearch.model.JobPost
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Retrofit Interface Service for retrieving GitHub Jobs
 */
interface RetrofitJobService {

    @GET("positions.json")
    fun getJobs(): Observable<List<JobPost>>
}
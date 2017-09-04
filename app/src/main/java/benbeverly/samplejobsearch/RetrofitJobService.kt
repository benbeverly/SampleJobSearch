package benbeverly.samplejobsearch

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Retrofit Interface Service for retrieving GitHub Jobs
 */
interface RetrofitJobService {

    @GET("positions.json")
    fun getJobs(): Observable<List<JobPost>>
}
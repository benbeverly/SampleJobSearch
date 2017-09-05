package benbeverly.samplejobsearch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    private var jobRecyclerAdapter = JobRecyclerAdapter()
    private lateinit var service: RetrofitJobService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Skipping doing this via dependency injection with Dagger2
        val retrofit = Retrofit.Builder()
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        service = retrofit.create<RetrofitJobService>(RetrofitJobService::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        recycler_view_job.layoutManager = LinearLayoutManager(context)
        recycler_view_job.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recycler_view_job.adapter = jobRecyclerAdapter

        service.getJobs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { jobList ->
                            jobRecyclerAdapter.appendNewJobs(jobList)
                        },
                        { error ->
                            Toast.makeText(context, getString(R.string.error_get_job, error.message),
                                    Toast.LENGTH_LONG).show()
                        }
                )
    }
}

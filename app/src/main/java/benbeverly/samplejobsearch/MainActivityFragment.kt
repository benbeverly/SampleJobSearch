package benbeverly.samplejobsearch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import benbeverly.samplejobsearch.data.JobPost
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    private var jobRecyclerAdapter = JobRecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        recycler_view_job.layoutManager = LinearLayoutManager(context)
        recycler_view_job.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recycler_view_job.adapter = jobRecyclerAdapter

        jobRecyclerAdapter.appendNewJobs(makeMockList())
    }

    private fun makeMockList(): ArrayList<JobPost> {
        val newList = ArrayList<JobPost>()
        newList.add(JobPost("1111", title = "Job 1", location = "Miami, FL", company = "Company #1"))
        newList.add(JobPost("2222", title = "Job 2", location = "San Jose, CA", company = "Company #2"))
        newList.add(JobPost("3333", title = "Job 3", location = "San Jose, CA", company = "Company #3"))
        newList.add(JobPost("4444", title = "Job 4", location = "4 town", company = "Company #4"))
        return newList
    }
}

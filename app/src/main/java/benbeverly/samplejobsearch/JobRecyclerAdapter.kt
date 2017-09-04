package benbeverly.samplejobsearch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import benbeverly.samplejobsearch.data.JobPost

/**
 * Adapter for listing job posts
 */
class JobRecyclerAdapter : RecyclerView.Adapter<JobViewHolder>() {
    private val jobList: ArrayList<JobPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_job, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder?, position: Int) {
        holder?.bind(jobList[position])
    }

    override fun getItemCount(): Int = jobList.size

    fun appendNewJobs(newJobs: List<JobPost>) {
        jobList.addAll(newJobs)
    }
}
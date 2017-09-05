package benbeverly.samplejobsearch.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import benbeverly.samplejobsearch.R
import benbeverly.samplejobsearch.model.JobPost

/**
 * Adapter for listing job posts
 */
class JobRecyclerAdapter : RecyclerView.Adapter<JobViewHolder>() {

    private val jobPostList: ArrayList<JobPost> = ArrayList()
    private var jobClickedListener: JobClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_job, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder?, position: Int) {
        holder?.bind(jobPostList[position], jobClickedListener)
    }

    override fun getItemCount(): Int = jobPostList.size

    fun appendNewJobs(newJobPosts: List<JobPost>) {
        jobPostList.addAll(newJobPosts)
        notifyDataSetChanged()
    }

    fun setOnJobClickedListener(jobClickedListener: JobClickedListener) {
        this.jobClickedListener = jobClickedListener
    }
}
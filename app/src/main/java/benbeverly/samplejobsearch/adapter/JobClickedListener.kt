package benbeverly.samplejobsearch.adapter

import benbeverly.samplejobsearch.model.JobPost

/**
 * Used to listen for when a job is clicked within a [JobRecyclerAdapter] / [JobViewHolder]
 */
interface JobClickedListener {
    fun onJobClicked(jobPost: JobPost)
}
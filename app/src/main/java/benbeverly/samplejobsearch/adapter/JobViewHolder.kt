package benbeverly.samplejobsearch.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import benbeverly.samplejobsearch.model.JobPost
import kotlinx.android.synthetic.main.view_holder_job.view.*

/**
 * View to quickly display job data in a list.
 * Via [JobRecyclerAdapter]
 */
class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(jobPost: JobPost, onJobClickedListener: JobClickedListener?) {
        itemView.text_company.text = jobPost.company
        itemView.text_title.text = jobPost.title
        itemView.text_location.text = jobPost.location

        itemView.setOnClickListener {
            onJobClickedListener?.onJobClicked(jobPost)
        }
    }
}
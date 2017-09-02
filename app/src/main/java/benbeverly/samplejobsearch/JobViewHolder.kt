package benbeverly.samplejobsearch

import android.support.v7.widget.RecyclerView
import android.view.View
import benbeverly.samplejobsearch.data.JobPost
import kotlinx.android.synthetic.main.view_holder_job.view.*

/**
 * View to quickly display job data in a list.
 * Via [JobRecyclerAdapter]
 */
class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(job: JobPost) {
        itemView.text_company.text = job.company
        itemView.text_title.text = job.title
        itemView.text_location.text = job.location
    }
}
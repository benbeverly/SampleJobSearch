package benbeverly.samplejobsearch

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.view_holder_job.view.*

/**
 * View to quickly display job data in a list.
 * Via [JobRecyclerAdapter]
 */
class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(jobPost: JobPost) {
        itemView.text_company.text = jobPost.company
        itemView.text_title.text = jobPost.title
        itemView.text_location.text = jobPost.location
    }
}
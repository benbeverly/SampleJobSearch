package benbeverly.samplejobsearch.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import benbeverly.samplejobsearch.R
import benbeverly.samplejobsearch.model.JobPost
import com.google.gson.Gson


/**
 * Shows the details of a selected job
 */
class JobDetailFragment : BaseFragment() {

    private lateinit var jobPost: JobPost

    companion object {
        private val ARG_JOB = "arg_job"

        fun newInstance(jobPost: JobPost): JobDetailFragment {
            val instance = JobDetailFragment()
            val bundle = Bundle()
            bundle.putString(ARG_JOB, Gson().toJson(jobPost))
            instance.arguments = bundle

            return instance
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments == null) {
            throw IllegalArgumentException("Arguments with JobPost required for JobDetailFragment")
        }

        jobPost = Gson().fromJson(arguments.getString(ARG_JOB), JobPost::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_job_detail, container, false)
    }

    override fun getTitle(): String? = jobPost.title
}
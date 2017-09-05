package benbeverly.samplejobsearch.model

import com.google.gson.annotations.SerializedName

/**
 * Data class describing a job posting.
 */
data class JobPost(@SerializedName("id") val id: String? = null,
                   @SerializedName("created_at") val createdAt: String? = null,
                   @SerializedName("getTitle")val title: String? = null,
                   @SerializedName("location") val location: String? = null,
                   @SerializedName("type") val type: String? = null,
                   @SerializedName("description") val description: String? = null,
                   @SerializedName("how_to_apply") val howToApply: String? = null,
                   @SerializedName("company") val company: String? = null,
                   @SerializedName("company_url") val companyUrl: String? = null,
                   @SerializedName("company_logo") val companyLogo: String? = null,
                   @SerializedName("url") val url: String? = null)
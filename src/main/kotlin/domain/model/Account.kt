package domain.model

import com.google.gson.annotations.SerializedName

data class Account(@SerializedName("active-card") val activeCard: Boolean = false,
                   @SerializedName("available-limit") val availableLimit: Int? = null)
package domain.usecases.utils

import com.google.gson.Gson
import domain.model.Response
import domain.usecases.UseCase

class ConvertResponse(private val gson: Gson): UseCase<String?> {
    private var response: Response? = null

    override fun execute(): String? {
        if (response == null) {
            return null
        }
        return gson.toJson(response)
    }

    fun with(response: Response): ConvertResponse {
        this.response = response
        return this
    }
}
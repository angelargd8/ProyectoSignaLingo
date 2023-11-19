package com.angelaxd.proyectosignalingo.data

/*data class SignInResult(
    val data: User?,
    val errorMessage: String?

)*/

data class User(
    val id: String?,
    val userId: String,
    val username: String?,
    val photoUrl: String?
){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "id" to this.id!!,
            "userId" to this.userId,
            "username" to this.username!!,
            "photoUrl" to this.photoUrl!!
        )
    }
}

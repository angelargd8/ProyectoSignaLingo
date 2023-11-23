package com.angelaxd.proyectosignalingo.data

sealed class VideoState{
    class SuccessV(val data: MutableList<Video>): VideoState()
    class FailureV(val message: String): VideoState()
    object LoadingV: VideoState()
    object EmptyV : VideoState()
}

package model

import java.io.File

data class MediaSourceEntity(
    var id:Int,
    var name: String,
    var file: File?,
    var urlPass: String,
    var ingooPass: String,
    var mediaType: Enums,
    var isPlaing: Boolean
)
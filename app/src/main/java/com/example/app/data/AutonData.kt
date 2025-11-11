package com.example.app.data

import io.oliverj.skaffold.data.PageData
import io.oliverj.skafold.processor.SerializableData
import kotlinx.serialization.Serializable

@Serializable
@SerializableData
class AutonData(var points: Int = 0) : PageData("auton") {
}
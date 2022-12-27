package com.kr.components.textFieldComponent

data class TextFieldData(
    var text: String = "",
    var isValid:Boolean = false,
    var state:STATE = STATE.NORMAL
)



enum class STATE (labelText:String?){
    NORMAL(null),
    DISABLED(null),
    ERROR(labelText = null),
    SUCCESS(labelText = null)
}
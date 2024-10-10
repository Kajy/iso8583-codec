package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.{Codec, TransformSyntax}

case class PhoneLastDigits460316(value: String) extends DeviceData4603XX

object PhoneLastDigits460316 {
  val codec: Codec[PhoneLastDigits460316] =
    LLVAR_ANS.as[PhoneLastDigits460316]
}

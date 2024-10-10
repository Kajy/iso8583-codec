package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field46.field3.DeviceData4603XX
import scodec.{Codec, TransformSyntax}

case class SerialNumber460301(value: String) extends DeviceData4603XX

object SerialNumber460301 {
  val codec: Codec[SerialNumber460301] = LLVAR_AN.as[SerialNumber460301]
}

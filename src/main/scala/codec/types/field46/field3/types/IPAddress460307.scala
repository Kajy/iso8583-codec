package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.{Codec, TransformSyntax}

case class IPAddress460307(value: String) extends DeviceData4603XX

object IPAddress460307 {
  val codec: Codec[IPAddress460307] = LLVAR_ANS.as[IPAddress460307]
}

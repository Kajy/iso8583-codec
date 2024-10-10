package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.{Codec, TransformSyntax}

case class Location460308(value: String) extends DeviceData4603XX

object Location460308 {
  val codec: Codec[Location460308] = LLVAR_ANS.as[Location460308]
}

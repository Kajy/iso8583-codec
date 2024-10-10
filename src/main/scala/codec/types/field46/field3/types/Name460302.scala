package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.{Codec, TransformSyntax}

case class Name460302(value: String) extends DeviceData4603XX

object Name460302 {
  val codec: Codec[Name460302] = LLVAR_ANS.as[Name460302]
}

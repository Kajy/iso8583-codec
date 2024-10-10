package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_ANS
import codec.types.field46.field3.DeviceData4603XX
import scodec.Codec

case class OSIdentifier460305(value: String) extends DeviceData4603XX

object OSIdentifier460305 {
  val codec: Codec[OSIdentifier460305] = LLVAR_ANS.as[OSIdentifier460305]
}

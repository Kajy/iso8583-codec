package codec.types.field46.field3.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.field46.field3.DeviceData4603XX
import scodec.Codec

case class HardwareIdentifier460310(value: String) extends DeviceData4603XX

object HardwareIdentifier460310 {
  val codec: Codec[HardwareIdentifier460310] = LLVAR_AN.as[HardwareIdentifier460310]
}

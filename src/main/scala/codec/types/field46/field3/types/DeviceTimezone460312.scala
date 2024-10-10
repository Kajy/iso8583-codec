package codec.types.field46.field3.types

import codec.FieldCodecs.{LLVAR_AN, LLVAR_N}
import codec.types.field46.field3.DeviceData4603XX
import scodec.Codec

case class DeviceTimezone460312(
    value: String
) extends DeviceData4603XX

object DeviceTimezone460312 {
  val codec: Codec[DeviceTimezone460312] = LLVAR_AN.as[DeviceTimezone460312]
}

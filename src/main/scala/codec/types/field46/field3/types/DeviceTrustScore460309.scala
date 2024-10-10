package codec.types.field46.field3.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field46.field3.DeviceData4603XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs.mappedEnum

case class DeviceTrustScore460309(
    value: String
) extends DeviceData4603XX

object DeviceTrustScore460309 {
  val codec: Codec[DeviceTrustScore460309] = LLVAR_N.as[DeviceTrustScore460309]
}

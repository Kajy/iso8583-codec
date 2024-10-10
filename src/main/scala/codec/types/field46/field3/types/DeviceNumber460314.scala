package codec.types.field46.field3.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field46.field3.DeviceData4603XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs.mappedEnum

case class DeviceNumber460314(
    value: String
) extends DeviceData4603XX

object DeviceNumber460314 {
  val codec: Codec[DeviceNumber460314] = LLVAR_N.as[DeviceNumber460314]
}

package codec.types.field46.field3.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field46.field3.DeviceData4603XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.mappedEnum

case class TimezoneConfiguration460313(
    configBy: TimezoneConfiguration460313.Configuration
) extends DeviceData4603XX

object TimezoneConfiguration460313 {
  sealed abstract class Configuration(val value: String) extends StringEnumEntry

  object Configuration extends StringEnum[Configuration] {
    val values: IndexedSeq[Configuration] = findValues

    case object BY_NETWORK extends Configuration("01")
    case object BY_USER extends Configuration("02")

    val mapping: Map[Configuration, String] =
      Configuration.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[TimezoneConfiguration460313] = LLVAR_N(
    mappedEnum(N, Configuration.mapping)
  ).as[TimezoneConfiguration460313]
}

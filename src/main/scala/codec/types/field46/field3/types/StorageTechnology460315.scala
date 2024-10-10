package codec.types.field46.field3.types

import codec.FieldCodecs.{AN, LLVAR}
import codec.types.field46.field3.DeviceData4603XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.Codec
import scodec.codecs.mappedEnum

case class StorageTechnology460315(
    `type`: StorageTechnology460315.TechnologyType
) extends DeviceData4603XX

object StorageTechnology460315 {
  sealed abstract class TechnologyType(val value: String)
      extends StringEnumEntry

  object TechnologyType extends StringEnum[TechnologyType] {
    val values: IndexedSeq[TechnologyType] = findValues

    case object DEVICE_MEMORY extends TechnologyType("01")
    case object DEVICE_MEMORY_PROTECTED extends TechnologyType("02")
    case object SERVER extends TechnologyType("03")
    case object TRUSTED_EXECUTION_ENV extends TechnologyType("04")
    case object SECURE_ELEMENT extends TechnologyType("05")
    case object VIRTUAL_EXECUTION_ENV extends TechnologyType("06")

    val mapping: Map[TechnologyType, String] =
      TechnologyType.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[StorageTechnology460315] = LLVAR(
    mappedEnum(AN, TechnologyType.mapping)
  ).as[StorageTechnology460315]
}

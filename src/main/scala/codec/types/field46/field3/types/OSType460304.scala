package codec.types.field46.field3.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field46.field3.DeviceData4603XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.mappedEnum
import scodec.{Codec, TransformSyntax}

case class OSType460304(
    `type`: OSType460304.Type
) extends DeviceData4603XX

object OSType460304 {
  sealed abstract class Type(val value: String) extends StringEnumEntry

  object Type extends StringEnum[Type] {
    val values: IndexedSeq[Type] = findValues

    case object ANDROID_VISA extends Type("01")
    case object IOS_VISA extends Type("02")
    case object WINDOWS_VISA extends Type("03")
    case object BLACKBERRY_VISA extends Type("04")
    case object TIZEN_VISA extends Type("05")
    case object OTHER_VISA extends Type("06")

    val mapping: Map[Type, String] =
      Type.valuesToEntriesMap.map(_.swap)
  }
  val codec: Codec[OSType460304] = LLVAR_N(
    mappedEnum(N, Type.mapping)
  ).as[OSType460304]
}

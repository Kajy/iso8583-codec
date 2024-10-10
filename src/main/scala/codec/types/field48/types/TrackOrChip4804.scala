package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values._
import scodec.Codec
import scodec.codecs._

case class TrackOrChip4804(`type`: TrackOrChip4804.Type) extends PrivateData48XX

object TrackOrChip4804 {
  sealed abstract class Type(val value: String) extends StringEnumEntry

  object EnvType extends StringEnum[Type] {
    val values = findValues

    case object TRACK_READING extends Type("01")
    case object CHIP_READING extends Type("02")
    case object MANUAL extends Type("03")
    case object OTHER extends Type("99")

    val mapping = EnvType.valuesToEntriesMap.map(_.swap)
    val codec = "OperationType" | mappedEnum(N, mapping)
  }

  val codec: Codec[TrackOrChip4804] = LLVAR_N(EnvType.codec).as[TrackOrChip4804]
}

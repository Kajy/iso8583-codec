package codec.types.field22

import codec.FieldCodecs.N
import codec.types.field22.ReadingMode22.{ CardReadingMode, PinEntryMode }
import enumeratum.values.{ StringEnum, StringEnumEntry }
import scodec.codecs.mappedEnum
import scodec.{ Codec, TransformSyntax, ValueCodecEnrichedWithHListSupport }

case class ReadingMode22(
    cardReadingMode: CardReadingMode,
    pinEntryMode: PinEntryMode
)

object ReadingMode22 {
  sealed abstract class CardReadingMode(val value: String) extends StringEnumEntry

  object CardReadingMode extends StringEnum[CardReadingMode] {

    val values: IndexedSeq[CardReadingMode] = findValues

    case object MANUAL                 extends CardReadingMode("00")
    case object CONTACT_STRIP          extends CardReadingMode("01")
    case object CONTACTLESS_STRIP      extends CardReadingMode("02")
    case object CONTACT_CHIP           extends CardReadingMode("03")
    case object CONTACTLESS_CHIP       extends CardReadingMode("04")
    case object MANUAL_FALLBACK_CHIP   extends CardReadingMode("05")
    case object FALLBACK_CHIP          extends CardReadingMode("06")
    case object PRESTORED_PAYMENT_DATA extends CardReadingMode("10")
    case object PAN_ECOMMERCE          extends CardReadingMode("81")
    case object OTHER                  extends CardReadingMode("99")

    val codecMapping: Map[CardReadingMode, String] =
      CardReadingMode.valuesToEntriesMap.map(_.swap)

  }

  sealed abstract class PinEntryMode(val value: String) extends StringEnumEntry

  object PinEntryMode extends StringEnum[PinEntryMode] {

    val values: IndexedSeq[PinEntryMode] = findValues

    case object NO_PIN    extends PinEntryMode("00")
    case object PIN_ENTRY extends PinEntryMode("01")
    case object `3DS`     extends PinEntryMode("02")
    case object OTHER     extends PinEntryMode("99")

    val codecMapping: Map[PinEntryMode, String] =
      PinEntryMode.valuesToEntriesMap.map(_.swap)

  }

  val codec: Codec[ReadingMode22] =
    (mappedEnum(N(2), CardReadingMode.codecMapping) ::
      mappedEnum(N(2), PinEntryMode.codecMapping)).as[ReadingMode22]

}

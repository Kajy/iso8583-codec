package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax, ValueCodecEnrichedWithHListSupport}

case class TransactionAnalysis4815(status: TransactionAnalysis4815.Status, reason: List[TransactionAnalysis4815.Reason]) extends PrivateData48XX

object TransactionAnalysis4815 {
  sealed abstract class Status(val value: String) extends StringEnumEntry

  object Status extends StringEnum[Status] {
    val values = findValues

    case object CI extends Status("01") // Continue processing with information
    case object CW extends Status("02") // Continue processing with warning
    case object DI extends Status("03") // Decline issuer decision
    case object DS extends Status("04") // Decline suspicious

    val mapping              = Status.valuesToEntriesMap.map(_.swap)
    val codec: Codec[Status] = "Status" | mappedEnum(N(2), mapping)
  }

  sealed abstract class Reason(val value: String) extends StringEnumEntry

  object Reason extends StringEnum[Reason] {
    val values = findValues

    case object CAM extends Reason("01")
    case object CCH extends Reason("02")
    case object CRN extends Reason("03")
    case object CVF extends Reason("04")
    case object CVU extends Reason("05")
    case object CVX extends Reason("06")
    case object DAF extends Reason("07")
    case object DAU extends Reason("08")
    case object DMM extends Reason("09")
    case object DNC extends Reason("10")
    case object EXP extends Reason("11")
    case object FER extends Reason("12")
    case object FUZ extends Reason("13")
    case object ICT extends Reason("14")
    case object NMK extends Reason("15")
    case object OVE extends Reason("16")
    case object OVF extends Reason("17")
    case object OVP extends Reason("18")
    case object OVU extends Reason("19")
    case object PKC extends Reason("20")
    case object PPC extends Reason("21")
    case object PTB extends Reason("22")
    case object PWE extends Reason("23")
    case object REP extends Reason("24")
    case object SKC extends Reason("25")
    case object SNA extends Reason("26")
    case object UTP extends Reason("27")
    case object WOC extends Reason("28")

    val mapping              = Reason.valuesToEntriesMap.map(_.swap)
    val codec: Codec[Reason] = "Reason" | mappedEnum(N(2), Reason.mapping)
  }

  val codec: Codec[TransactionAnalysis4815] = LLVAR_N(Status.codec :: list(Reason.codec)).as[TransactionAnalysis4815]

}

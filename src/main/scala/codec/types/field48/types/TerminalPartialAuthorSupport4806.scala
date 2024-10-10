package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values._
import scodec.Codec
import scodec.codecs._

case class TerminalPartialAuthorSupport4806(
    `type`: TerminalPartialAuthorSupport4806.TerminalSupport
) extends PrivateData48XX

object TerminalPartialAuthorSupport4806 {
  sealed abstract class TerminalSupport(val value: String)
      extends StringEnumEntry

  object TerminalSupport extends StringEnum[TerminalSupport] {
    val values = findValues

    case object NOT_SUPPORTED extends TerminalSupport("00")
    case object SUPPORT_WITHDRAWAL_PURCHASE_ONLY extends TerminalSupport("10")
    case object SUPPORT_PURCHASE_CASHBACK extends TerminalSupport("01")
    case object SUPPORT_ALL extends TerminalSupport("11")

    val mapping = TerminalSupport.valuesToEntriesMap.map(_.swap)
    val codec = "OperationType" | mappedEnum(N, mapping)
  }

  val codec: Codec[TerminalPartialAuthorSupport4806] =
    LLVAR_N(TerminalSupport.codec).as[TerminalPartialAuthorSupport4806]
}

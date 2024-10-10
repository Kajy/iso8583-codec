package codec.types

import enumeratum.{Enum, EnumEntry}
import scodec.bits.{ByteVector, HexStringSyntax}
import scodec.codecs._

sealed abstract class ProcessingCode03 extends EnumEntry

object ProcessingCode03 extends Enum[ProcessingCode03] {

  val values = findValues

  case object PAYMENT extends ProcessingCode03
  case object WITHDRAWAL extends ProcessingCode03
  case object PAYMENT_CASHBACK extends ProcessingCode03
  case object QUASICASH extends ProcessingCode03
  case object MANUAL_CASH extends ProcessingCode03
  case object REFUND_OR_CREDIT extends ProcessingCode03
  case object FUNDS_TRANSFER_DEBIT extends ProcessingCode03
  case object FUNDS_TRANSFER_CREDIT extends ProcessingCode03
  case object VTS_OR_MDES_ENROLLMENT extends ProcessingCode03

  val hexMapping: Map[ProcessingCode03, ByteVector] = Map(
    ProcessingCode03.PAYMENT -> hex"0x00",
    ProcessingCode03.WITHDRAWAL -> hex"01",
    ProcessingCode03.PAYMENT_CASHBACK -> hex"09",
    ProcessingCode03.QUASICASH -> hex"11",
    ProcessingCode03.MANUAL_CASH -> hex"17",
    ProcessingCode03.REFUND_OR_CREDIT -> hex"20",
    ProcessingCode03.FUNDS_TRANSFER_DEBIT -> hex"41",
    ProcessingCode03.FUNDS_TRANSFER_CREDIT -> hex"42",
    ProcessingCode03.VTS_OR_MDES_ENROLLMENT -> hex"93"
  )

  val codec = paddedFixedSizeBits(
    24,
    mappedEnum(bytes(1), ProcessingCode03.hexMapping),
    ignore(16)
  )
}

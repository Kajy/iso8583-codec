package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import codec.types.field48.types.RecurringPaymentIndicator4835.RecurringPaymentIndicator
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class RecurringPaymentIndicator4835(`type`: RecurringPaymentIndicator) extends PrivateData48XX

object RecurringPaymentIndicator4835 {

  sealed abstract class RecurringPaymentIndicator(val value: String) extends StringEnumEntry

  object RecurringPaymentIndicator extends StringEnum[RecurringPaymentIndicator] {

    val values = findValues

    case object UNKNOW_SEQ_NB            extends RecurringPaymentIndicator("01")
    case object FIRST_RECURRING          extends RecurringPaymentIndicator("02")
    case object SUBSEQUENT_RECURRING     extends RecurringPaymentIndicator("03")
    case object INSTALLMENT              extends RecurringPaymentIndicator("04")
    case object INSTALLMENT_OR_RECURRING extends RecurringPaymentIndicator("05")
    case object NOT_SPECIFIED            extends RecurringPaymentIndicator("99")

    val mapping = RecurringPaymentIndicator.valuesToEntriesMap.map(_.swap)
    val codec   = "RecurringPaymentIndicator" | mappedEnum(N, mapping)
  }

  val codec: Codec[RecurringPaymentIndicator4835] = LLVAR_N(RecurringPaymentIndicator.codec).as[RecurringPaymentIndicator4835]
}

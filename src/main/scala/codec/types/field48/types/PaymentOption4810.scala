package codec.types.field48.types

import codec.FieldCodecs.{ LLVAR_N, N }
import codec.types.field48.PrivateData48XX
import enumeratum.values.{ StringEnum, StringEnumEntry }
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }

case class PaymentOption4810(option: PaymentOption4810.PaymentOption) extends PrivateData48XX

object PaymentOption4810 {
  sealed abstract class PaymentOption(val value: String) extends StringEnumEntry

  object PaymentOption extends StringEnum[PaymentOption] {
    val values = findValues

    case object IMMEDIATE_CASH      extends PaymentOption("01")
    case object DEFERRED_CASH       extends PaymentOption("02")
    case object CREDIT              extends PaymentOption("03")
    case object THREE_TIMES_PAYMENT extends PaymentOption("04")

    val mapping = PaymentOption.valuesToEntriesMap.map(_.swap)
    val codec   = "PaymentOption" | mappedEnum(N, mapping)
  }

  val codec: Codec[PaymentOption4810] =
    LLVAR_N(PaymentOption.codec).as[PaymentOption4810]

}

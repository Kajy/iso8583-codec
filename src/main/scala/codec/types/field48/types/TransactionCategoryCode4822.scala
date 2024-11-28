package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import enumeratum.values.*
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class TransactionCategoryCode4822(
    categoryCode: TransactionCategoryCode4822.TransactionCategoryCode
) extends PrivateData48XX

object TransactionCategoryCode4822 {
  sealed abstract class TransactionCategoryCode(val value: String) extends StringEnumEntry

  object TransactionCategoryCode extends StringEnum[TransactionCategoryCode] {
    val values = findValues

    case object VEHICLE_RENTEL          extends TransactionCategoryCode("01")
    case object CASH_DISBURSEMENT       extends TransactionCategoryCode("02")
    case object RESTAURANT              extends TransactionCategoryCode("03")
    case object HOTEL                   extends TransactionCategoryCode("04")
    case object HOSPITALIZATION_COLLEGE extends TransactionCategoryCode("05")
    case object PAYMENT_TRANSACTION     extends TransactionCategoryCode("06")
    case object RETAIL_SALE             extends TransactionCategoryCode("07")
    case object COMMERCE_ORDER          extends TransactionCategoryCode("08")
    case object UNIQUE                  extends TransactionCategoryCode("09")
    case object TRANSPORTATION_SERVICES extends TransactionCategoryCode("10")
    case object ATM_CASH                extends TransactionCategoryCode("11")

    val mapping = TransactionCategoryCode.valuesToEntriesMap.map(_.swap)
    val codec   = "TransactionCategoryCode" | mappedEnum(N, mapping)
  }

  val codec: Codec[TransactionCategoryCode4822] =
    LLVAR_N(TransactionCategoryCode.codec).as[TransactionCategoryCode4822]

}

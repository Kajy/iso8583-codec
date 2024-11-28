package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import codec.types.field48.types.MerchantAdviceCode4850.MerchantAdviceCode
import enumeratum.values.*
import scodec.codecs.*
import scodec.{Codec, TransformSyntax}

case class MerchantAdviceCode4850(code: MerchantAdviceCode) extends PrivateData48XX

object MerchantAdviceCode4850 {
  sealed abstract class MerchantAdviceCode(val value: String) extends StringEnumEntry

  object MerchantAdviceCode extends StringEnum[MerchantAdviceCode] {
    val values = findValues

    case object NEW_ACCOUNT_INF_AVAILABLE        extends MerchantAdviceCode("01")
    case object CANNOT_APPROVE                   extends MerchantAdviceCode("02")
    case object DO_NOT_TRY_AGAIN                 extends MerchantAdviceCode("03")
    case object TOKEN_REQ_NOT_FULFILLED          extends MerchantAdviceCode("04")
    case object NEGOCIATED_VALUE_NOT_APPROVED    extends MerchantAdviceCode("05")
    case object PAYMENT_CANCELLATION             extends MerchantAdviceCode("21")
    case object NOT_QUALIFY_PRODUCT_CODE         extends MerchantAdviceCode("22")
    case object RETRY_AFTER_1_HOUR               extends MerchantAdviceCode("24")
    case object RETRY_AFTER_24_HOURS             extends MerchantAdviceCode("25")
    case object RETRY_AFTER_2_DAYS               extends MerchantAdviceCode("26")
    case object RETRY_AFTER_4_DAYS               extends MerchantAdviceCode("27")
    case object RETRY_AFTER_6_DAYS               extends MerchantAdviceCode("28")
    case object RETRY_AFTER_8_DAYS               extends MerchantAdviceCode("29")
    case object RETRY_AFTER_10_DAYS              extends MerchantAdviceCode("30")
    case object CONSUMER_NON_RELOAD_PREPAID_CARD extends MerchantAdviceCode("40")
    case object CONSUMER_SINGLE_USE_VIRTUAL_CARD extends MerchantAdviceCode("41")
    case object SCORE_EXCEEDS_THRESHOLD_VALUE    extends MerchantAdviceCode("42")

    val mapping = MerchantAdviceCode.valuesToEntriesMap.map(_.swap)
    val codec   = "MerchantAdviceCode" | mappedEnum(N, mapping)
  }

  val codec: Codec[MerchantAdviceCode4850] = LLVAR_N(MerchantAdviceCode.codec).as[MerchantAdviceCode4850]
}

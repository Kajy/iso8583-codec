package codec.types.field54

import codec.FieldCodecs.{ ANS, LLVAR, N }
import codec.types.field54.AdditionalAmounts.AmountType
import enumeratum.values.*
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }
import utils.Currency

import scala.util.Try

case class AdditionalAmounts54(datas: List[AdditionalAmounts])

object AdditionalAmounts54 {
  val codec: Codec[AdditionalAmounts54] = LLVAR(list(AdditionalAmounts.codec)).as[AdditionalAmounts54]
}

case class AdditionalAmounts(accountType: String, amountType: AmountType, currency: Currency, side: String, amount: String) {
  def toHexString = s"$accountType${amountType.value}${currency.numericCodeAsString}$side$amount"
}

object AdditionalAmounts {
  sealed abstract class AmountType(val value: String) extends StringEnumEntry

  object AmountType extends StringEnum[AmountType] {
    val values = findValues

    case object LEDGER_BALANCE              extends AmountType("01")
    case object AVAILABLE_BALANCE           extends AmountType("02")
    case object AMOUNT_OWING                extends AmountType("03")
    case object AMOUNT_DUE                  extends AmountType("04")
    case object HEALTHCARE_ELIGIBILITY      extends AmountType("10")
    case object PRESCRIPTION_ELIGIBILITY    extends AmountType("11")
    case object VISION_RX_ELIGIBILITY       extends AmountType("12")
    case object RUF13                       extends AmountType("13")
    case object RUF14                       extends AmountType("14")
    case object MCD_PREPAID_ONLINE_FEE      extends AmountType("17")
    case object AMOUNT_CASH_BACK            extends AmountType("40")
    case object TRANSACTION_PAYABLE_FEE     extends AmountType("42")
    case object CUMULATIVE_TOTAL_AUTHORIZED extends AmountType("43")
    case object AMOUNT_GRATUITY             extends AmountType("44")
    case object AMOUNT_ANTICIPED            extends AmountType("45")
    case object ORIGINAL                    extends AmountType("57")
    case object POI                         extends AmountType("58")
    case object LIMIT_BALANCE_AVAILABLE     extends AmountType("59")
    case object VISA_MONEY_TRANSFER         extends AmountType("95")

    val mapping = AmountType.valuesToEntriesMap.map(_.swap)
    val codec   = "AmountType" | mappedEnum(N(2), mapping)
  }

  val codec: Codec[AdditionalAmounts] = ANS(20).xmap(fromString, _.toHexString)

  def fromString(data: String): AdditionalAmounts =
    Try {
      val accountType = data.slice(0, 2)
      val amountType  = AmountType.withValueOpt(data.slice(2, 4)).get
      val currency    = Currency.unsafeFrom(data.slice(4, 7))
      val side        = data.slice(7, 8)
      val amount      = data.slice(8, 20)
      AdditionalAmounts(accountType, amountType, currency, side, amount)
    }.getOrElse(throw new Exception("AdditionalAmounts invalid format"))

}

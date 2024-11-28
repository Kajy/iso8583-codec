package codec.types.field46.field2.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field46.field2.WalletData4602XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.codecs.mappedEnum
import scodec.{Codec, TransformSyntax}

case class XPayId460207(id: XPayId460207.XPayId) extends WalletData4602XX

object XPayId460207 {
  sealed abstract class XPayId(val value: String) extends StringEnumEntry

  object XPayId extends StringEnum[XPayId] {
    val values: IndexedSeq[XPayId] = findValues

    case object APPLE_PAY                     extends XPayId("01")
    case object GOOGLE_PAY                    extends XPayId("02")
    case object SAMSUNG_PAY                   extends XPayId("03")
    case object MERCHANT_TOKENIZATION_PROGRAM extends XPayId("04")
    case object UNKNOWN                       extends XPayId("99")

    val mapping: Map[XPayId, String] =
      XPayId.valuesToEntriesMap.map(_.swap)

    val codec: Codec[XPayId] = mappedEnum(LLVAR_N, XPayId.mapping)
  }

  val codec: Codec[XPayId460207] =
    XPayId.codec.as[XPayId460207]

}

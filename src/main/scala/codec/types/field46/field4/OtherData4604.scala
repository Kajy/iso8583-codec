package codec.types.field46.field4

import codec.FieldCodecs.{LLVAR, N}
import codec.types.WalletInfos46XX
import codec.types.field46.field4.`type`.{
  ActiveTokenNb460405,
  CVX2Result460404,
  CorrelationId460402,
  HolderName460406,
  PanSource460403,
  ProductConfig460401
}
import scodec.Codec
import scodec.codecs._

trait OtherData4604XX

case class OtherData4604(
    productConfig01: Option[ProductConfig460401],
    correlationId02: Option[CorrelationId460402],
    panSource03: Option[PanSource460403],
    cvx2Result04: Option[CVX2Result460404],
    activeTokenNb05: Option[ActiveTokenNb460405],
    holderName06: Option[HolderName460406]
) extends WalletInfos46XX

object OtherData4604 {
  private val subFieldsCodec: Codec[OtherData4604XX] =
    discriminated[OtherData4604XX]
      .by(N(2))
      .typecase("01", "ProductConfig01" | ProductConfig460401.codec)
      .typecase("02", "CorrelationId02" | CorrelationId460402.codec)
      .typecase("03", "PanSource03" | PanSource460403.codec)
      .typecase("04", "CVX2Result04" | CVX2Result460404.codec)
      .typecase("05", "ActiveTokenNb05" | ActiveTokenNb460405.codec)
      .typecase("06", "HolderName06" | HolderName460406.codec)

  val codec: Codec[OtherData4604] = LLVAR(list(subFieldsCodec)).xmap(
    fields => {
      val pc01 = fields.collectFirst({ case t: ProductConfig460401 => t })
      val cId02 = fields.collectFirst({ case t: CorrelationId460402 => t })
      val ps03 = fields.collectFirst({ case t: PanSource460403 => t })
      val cr04 = fields.collectFirst({ case t: CVX2Result460404 => t })
      val tNb05 = fields.collectFirst({ case t: ActiveTokenNb460405 => t })
      val hn06 = fields.collectFirst({ case t: HolderName460406 => t })
      OtherData4604(pc01, cId02, ps03, cr04, tNb05, hn06)
    },
    od =>
      List.concat(
        od.productConfig01,
        od.correlationId02,
        od.panSource03,
        od.cvx2Result04,
        od.activeTokenNb05,
        od.holderName06
      )
  )
}

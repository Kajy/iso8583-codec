package codec.types.field47

import codec.FieldCodecs.{LLVAR, N}
import codec.types.field47.types.IssuerBankCode4701
import scodec.Codec
import scodec.codecs._

trait AdditionalData47XX

case class AdditionalData47(issuerBankCode01: Option[IssuerBankCode4701])

object AdditionalData47 {
  private val subFieldCodec = {
    discriminated[AdditionalData47XX]
      .by(N(2))
      .typecase("01", "IssuerBankCode01" | IssuerBankCode4701.codec)
  }

  val codec: Codec[AdditionalData47] = list(subFieldCodec).xmap(
    fields => {
      val ibc01 = fields.collectFirst({ case t: IssuerBankCode4701 => t })
      AdditionalData47(ibc01)
    },
    ad => List.concat(ad.issuerBankCode01)
  )
}

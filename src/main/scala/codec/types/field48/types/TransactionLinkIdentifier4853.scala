package codec.types.field48.types

import codec.FieldCodecs.{ AN, LLVAR, LLVAR_ANS, N }
import codec.types.field48.PrivateData48XX
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }

case class TransactionLinkIdentifier4853(
    tlidNomenclature01: Option[TLIDNomenclature485301],
    tlid02: Option[TLID485302]
) extends PrivateData48XX

object TransactionLinkIdentifier4853 {

  private val subFieldCodec =
    discriminated[TransactionLinkIdentifier4853XX]
      .by(N(2))
      .typecase("01", "TLIDNomenclature01" | TLIDNomenclature485301.codec)
      .typecase("02", "TLID02" | TLID485302.codec)

  val codec: Codec[TransactionLinkIdentifier4853] = LLVAR(
    list(subFieldCodec).xmap(
      fields =>
        TransactionLinkIdentifier4853(
          fields.collectFirst { case t: TLIDNomenclature485301 => t },
          fields.collectFirst { case t: TLID485302 => t }
        ),
      afd =>
        List.concat(
          afd.tlidNomenclature01,
          afd.tlid02
        )
    )
  )

}

trait TransactionLinkIdentifier4853XX

case class TLIDNomenclature485301(reference: String) extends TransactionLinkIdentifier4853XX

object TLIDNomenclature485301 {
  val codec: Codec[TLIDNomenclature485301] = AN(1).as[TLIDNomenclature485301]
}

case class TLID485302(id: String) extends TransactionLinkIdentifier4853XX

object TLID485302 {

  val codec: Codec[TLID485302] = LLVAR_ANS.as[TLID485302]
}

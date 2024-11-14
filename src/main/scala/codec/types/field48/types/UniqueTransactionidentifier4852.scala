package codec.types.field48.types

import codec.FieldCodecs.{ AN, LLVAR, LLVAR_ANS, N }
import codec.types.field48.PrivateData48XX
import scodec.codecs.*
import scodec.{ Codec, TransformSyntax }

case class UniqueTransactionIdentifier4852(
    tidNomenclature01: Option[TIDNomenclature485201],
    tid02: Option[TID485202]
) extends PrivateData48XX

object UniqueTransactionIdentifier4852 {

  private val subFieldCodec =
    discriminated[UniqueTransactionIdentifier4852XX]
      .by(N(2))
      .typecase("01", "TIDNomenclature01" | TIDNomenclature485201.codec)
      .typecase("02", "TID02" | TID485202.codec)

  val codec: Codec[UniqueTransactionIdentifier4852] = LLVAR(
    list(subFieldCodec).xmap(
      fields =>
        UniqueTransactionIdentifier4852(
          fields.collectFirst { case t: TIDNomenclature485201 => t },
          fields.collectFirst { case t: TID485202 => t }
        ),
      afd =>
        List.concat(
          afd.tidNomenclature01,
          afd.tid02
        )
    )
  )

}

trait UniqueTransactionIdentifier4852XX

case class TIDNomenclature485201(reference: String) extends UniqueTransactionIdentifier4852XX

object TIDNomenclature485201 {
  val codec: Codec[TIDNomenclature485201] = AN(1).as[TIDNomenclature485201]
}

case class TID485202(id: String) extends UniqueTransactionIdentifier4852XX

object TID485202 {

  val codec: Codec[TID485202] = LLVAR_ANS.as[TID485202]
}

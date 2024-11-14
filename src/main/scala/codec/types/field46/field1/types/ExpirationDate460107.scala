package codec.types.field46.field1.types

import codec.FieldCodecs.{LLVAR_N, yearMonthFormatter}
import codec.types.field46.field1.TokenData4601XX
import scodec.{Codec, TransformSyntax}

import java.time.YearMonth

case class ExpirationDate460107(date: YearMonth) extends TokenData4601XX

object ExpirationDate460107 {

  val codec: Codec[ExpirationDate460107] = LLVAR_N
    .xmap(
      YearMonth.parse(_, yearMonthFormatter),
      (t: YearMonth) => t.format(yearMonthFormatter)
    )
    .as[ExpirationDate460107]

}

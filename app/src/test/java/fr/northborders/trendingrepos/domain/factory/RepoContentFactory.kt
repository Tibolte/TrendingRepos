package fr.northborders.trendingrepos.domain.factory

import fr.northborders.trendingrepos.data.model.RepoContentEntity
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomInt
import fr.northborders.trendingrepos.domain.factory.DataFactory.Factory.randomString
import fr.northborders.trendingrepos.domain.model.RepoContent

class RepoContentFactory {
    companion object {
        fun makeRepoContentEntity(): RepoContentEntity {
            return RepoContentEntity(
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString()
            )
        }

        fun makeRepoContent(): RepoContent {
            return RepoContent(
                randomString(),
                randomString(),
                randomString(),
                randomInt(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString(),
                randomString()
            )
        }

        fun makeContentForReadme(): String {
            val repoContent = "IyBXZSBhcmUgbm90IEdpZiBtYWtlcnMsIFdlIGFyZSBkZXZlbG9wZXJzClsh\nW01hd" +
                    "mVuIENlbnRyYWxdKGh0dHBzOi8vbWF2ZW4tYmFkZ2VzLmhlcm9rdWFw\ncC5jb2" +
                    "0vbWF2ZW4tY2VudHJhbC9jb20uZ2l0aHViLnRpYm9sdGUvZWxhc3Rp\nY2Rvd25" +
                    "sb2FkL2JhZGdlLnN2ZyldKGh0dHBzOi8vbWF2ZW4tYmFkZ2VzLmhl\ncm9rdWFw" +
                    "cC5jb20vbWF2ZW4tY2VudHJhbC9jb20uZ2l0aHViLnRpYm9sdGUv\nZWxhc3RpY" +
                    "2Rvd25sb2FkKQpbIVtBbmRyb2lkIEFyc2VuYWxdKGh0dHBzOi8v\naW1nLnNoaW" +
                    "VsZHMuaW8vYmFkZ2UvQW5kcm9pZCUyMEFyc2VuYWwtRWxhc3Rp\nY0Rvd25sb2F" +
                    "kLWJyaWdodGdyZWVuLnN2Zz9zdHlsZT1mbGF0KV0oaHR0cDov\nL2FuZHJvaWQt" +
                    "YXJzZW5hbC5jb20vZGV0YWlscy8xLzE3NDcpCgpSZWNlbnRs\neSBtZSBhbmQgb" +
                    "XkgZnJpZW5kIGNhbWUgYWNyb3NzIHRoaXMgZG93bmxvYWRp\nbmcgYW5pbWF0aW" +
                    "9uIG9uIERyaWJibGU6IGh0dHBzOi8vZHJpYmJibGUuY29t\nL3Nob3RzLzE4ODc" +
                    "4MTUtRG93bmxvYWQ/bGlzdD11c2VycyZvZmZzZXQ9NApX\nZSBmb3VuZCBpdCBz" +
                    "byBuaWNlIHRoYXQgd2UgZGVjaWRlZCB0byBkZXZlbG9w\nIGl0IGZvciBBbmRyb" +
                    "2lkIQoKV2UgaW1wbGVtZW50ZWQgaXQgd2l0aCBhIGN1\nc3RvbSB2aWV3LCBwbG" +
                    "F5aW5nIHdpdGggY2FudmFzIHJvdGF0aW9uIGFuZCBw\nYXRoIGRyYXdpbmcuCgo" +
                    "hW10oaHR0cHM6Ly9yYXcuZ2l0aHVidXNlcmNvbnRl\nbnQuY29tL1RpYm9sdGUv" +
                    "RWxhc3RpY0Rvd25sb2FkL21hc3Rlci9zdWNjZXNz\nLmdpZikKIVtdKGh0dHBzO" +
                    "i8vcmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbS9U\naWJvbHRlL0VsYXN0aWNEb3" +
                    "dubG9hZC9tYXN0ZXIvZmFpbC5naWYpCgojIyBT\neXN0ZW0gUmVxdWlyZW1lbnQ" +
                    "KQW5kcm9pZCB2Mi4yKwoKVXNhZ2UKPT09PT09\nPT09PT09PT09PT09PT09PT09" +
                    "PT09PT09PQoKR3JhYiBpdCBmcm9tIG1hdmVu\nOgoKYGBgZ3Jvb3Z5CiAgICBjb" +
                    "21waWxlICdjb20uZ2l0aHViLnRpYm9sdGU6\nZWxhc3RpY2Rvd25sb2FkOjEuMC" +
                    "4rJwpgYGBgCgoKRGVjbGFyZSB0aGlzIHZp\nZXcgaW4geW91ciBsYXlvdXQgbGl" +
                    "rZSBiZWxvdywgaXQncyBhbHNvIHBvc3Np\nYmxlIHRvIGluZmxhdGUgaXQgbWFu" +
                    "dWFsbHkuCgpgYGBqYXZhCiAgICA8aXMu\nYXJvbnRpYm8ubGlicmFyeS5FbGFzd" +
                    "GljRG93bmxvYWRWaWV3CiAgICAgICAg\nYW5kcm9pZDppZD0iQCtpZC9lbGFzdG" +
                    "ljX2Rvd25sb2FkX3ZpZXciCiAgICAg\nICAgYW5kcm9pZDpsYXlvdXRfd2lkdGg" +
                    "9IndyYXBfY29udGVudCIKICAgICAg\nICBhbmRyb2lkOmxheW91dF9oZWlnaHQ9" +
                    "IndyYXBfY29udGVudCIKICAgICAg\nICBhbmRyb2lkOmxheW91dF9jZW50ZXJJb" +
                    "lBhcmVudD0idHJ1ZSIvPgpgYGBg\nCgpBdCBmaXJzdCwgY2FsbCBzdGFydEludH" +
                    "JvKCkgdG8gbWFrZSB0aGUgdmll\ndyBiZSBhYmxlIHRvIGRpc3BsYXkgYW55IHB" +
                    "lcmNlbnRhZ2U6CgpgYGBqYXZh\nCiAgICBASW5qZWN0VmlldyhSLmlkLmVsYXN0" +
                    "aWNfZG93bmxvYWRfdmlldykg\nRWxhc3RpY0Rvd25sb2FkVmlldyBtRWxhc3RpY" +
                    "0Rvd25sb2FkVmlldzsKICAg\nIAogICAgbUVsYXN0aWNEb3dubG9hZFZpZXcuc3" +
                    "RhcnRJbnRybygpOwpgYGBg\nCgpTZXQgYW55IHByb2dyZXNzOgoKYGBgamF2YQo" +
                    "gICAgbUVsYXN0aWNEb3du\nbG9hZFZpZXcuc2V0UHJvZ3Jlc3MoMjUpOwpgYGBg" +
                    "CgpOb3RpZnkgaWYgdGhl\nIGRvd25sb2FkIGhhcyBmYWlsZWQgb3Igbm90OgoKY" +
                    "GBgamF2YQogICAgbUVs\nYXN0aWNEb3dubG9hZFZpZXcuc3VjY2VzcygpOyAvL1" +
                    "RoaXMgZnVuY3Rpb24g\nbW92ZXMgdGhlIGN1cnNvciB0byAxMDAgaWYgdGhlIHB" +
                    "yb2dyZXNzIGhhcyBu\nb3QgYmVlbiBzZXQgYWxyZWFkeQogICAgCiAgICBtRWxh" +
                    "c3RpY0Rvd25sb2Fk\nVmlldy5mYWlsKCk7CmBgYGAKCiMgUGFydGljaXBhdGluZ" +
                    "z8KTWFrZSB5b3Vy\nIHB1bGwgcmVxdWVzdHMgb24gZmVhdHVyZSBvciBidWdmaX" +
                    "ggYnJhbmNoZXMu\nCgpMaWNlbnNlCi0tLS0tLS0tLS0tCgogICAgQ29weXJpZ2h" +
                    "0IDIwMTUgVGhp\nYmF1bHQgR3XDqWdhbiBhbmQgQXJvbiBJbmdpIMOTc2thcnNz" +
                    "b24KCiAgICBM\naWNlbnNlZCB1bmRlciB0aGUgQXBhY2hlIExpY2Vuc2UsIFZlc" +
                    "nNpb24gMi4w\nICh0aGUgIkxpY2Vuc2UiKTsKICAgIHlvdSBtYXkgbm90IHVzZS" +
                    "B0aGlzIGZp\nbGUgZXhjZXB0IGluIGNvbXBsaWFuY2Ugd2l0aCB0aGUgTGljZW5" +
                    "zZS4KICAg\nIFlvdSBtYXkgb2J0YWluIGEgY29weSBvZiB0aGUgTGljZW5zZSBh" +
                    "dAoKICAg\nICAgIGh0dHA6Ly93d3cuYXBhY2hlLm9yZy9saWNlbnNlcy9MSUNFT" +
                    "lNFLTIu\nMAoKICAgIFVubGVzcyByZXF1aXJlZCBieSBhcHBsaWNhYmxlIGxhdy" +
                    "BvciBh\nZ3JlZWQgdG8gaW4gd3JpdGluZywgc29mdHdhcmUKICAgIGRpc3RyaWJ" +
                    "1dGVk\nIHVuZGVyIHRoZSBMaWNlbnNlIGlzIGRpc3RyaWJ1dGVkIG9uIGFuICJB" +
                    "UyBJ\nUyIgQkFTSVMsCiAgICBXSVRIT1VUIFdBUlJBTlRJRVMgT1IgQ09ORElUS" +
                    "U9O\nUyBPRiBBTlkgS0lORCwgZWl0aGVyIGV4cHJlc3Mgb3IgaW1wbGllZC4KIC" +
                    "Ag\nIFNlZSB0aGUgTGljZW5zZSBmb3IgdGhlIHNwZWNpZmljIGxhbmd1YWdlIGd" +
                    "v\ndmVybmluZyBwZXJtaXNzaW9ucyBhbmQKICAgIGxpbWl0YXRpb25zIHVuZGVy" +
                    "\nIHRoZSBMaWNlbnNlLgo=\n"
            return repoContent
        }
    }
}
# WorldEdit Wand Fabrication

By NitricAcid. Automatically restores the [WorldEdit Items](https://modrinth.com/mod/worldedit-items) Wand Axe to your creative inventory after it is cleared, using the same approach as [Create: Creative Tools Fabrications](https://github.com/NitricAcidDev/Create-Extra-Stuff/tree/main/create-creative-tools-fabrications).

For Minecraft 1.21.1 and NeoForge. Requires WorldEdit Items 2.0. To use the axe as a WorldEdit selection wand, bind it with `/tool selwand` while holding it; this mod only restores the item to your inventory.

The sole setting is `enabled` in `config/worldeditwandfabrication-client.toml`. Set it to `false` to disable restoration. The mod restores the axe to its last occupied inventory slot when possible, or to the first empty slot. It does not create another axe when one is already in your inventory or on your cursor.

The icon is a placeholder. Build with `./gradlew build` (or `gradlew.bat build` on Windows); the jar is written to `build/libs`.

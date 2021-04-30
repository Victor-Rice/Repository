import sample.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWeapons {
    Weapon testWeapon;
    int x; //clip
    int y; //currentBC
    int z; //ammo reserve
    @Before
    public void setup() {
        testWeapon = new Weapon("Pistol",9,44,16,false,16,1.4,160,7,10);
        x = testWeapon.clipSize;
        y = testWeapon.currentBulletCount;
        z = testWeapon.ammoReserve;

    }
        @Test
        public void testReloadIsNotNegative(){
            assertEquals(testWeapon.clipSize, testWeapon.currentBulletCount);
        }

        @Test
        public void testFireNeg(){
        //check intial stats

            assertTrue(testWeapon.clipSize==x);
            assertEquals(testWeapon.currentBulletCount, y);
            testWeapon.fire(10);
            assertTrue(testWeapon.currentBulletCount==y-10);
            testWeapon.fire(-10);
            assertTrue(testWeapon.currentBulletCount==y-10);

        }

        @Test
        public void testFireClip(){
            assertTrue(testWeapon.clipSize==x);
            assertEquals(testWeapon.currentBulletCount, y);
            testWeapon.fire(50);
            assertEquals(testWeapon.currentBulletCount, 0);
            testWeapon.fire(y);
            assertEquals(testWeapon.currentBulletCount, 0);
        }

        @Test
        public void testReload(){
        // testing if resets clip and draws from ammo reserve
            assertTrue(testWeapon.clipSize==x);
            assertEquals(testWeapon.currentBulletCount, y);
            assertTrue(testWeapon.ammoReserve==z);
            testWeapon.fire(y);
            assertTrue(testWeapon.currentBulletCount==0);
            testWeapon.reload(32);
            assertEquals(testWeapon.currentBulletCount, y);
            assertEquals(testWeapon.ammoReserve, z-y);
        }

        @Test
        public void testMultipleReloads(){
            assertEquals(testWeapon.currentBulletCount, y);
            assertTrue(testWeapon.ammoReserve==z);
            testWeapon.fire(y);
            assertTrue(testWeapon.currentBulletCount==0);
            testWeapon.reload(x);
            testWeapon.reload(x);
            testWeapon.reload(x);
            assertEquals(testWeapon.currentBulletCount, y);
            assertEquals(testWeapon.ammoReserve, z-y);
        }

        @Test
    public void testClipOverload(){
            testWeapon.fire(1);
            assertTrue(testWeapon.currentBulletCount==y-1);
            testWeapon.reload(x);
            assertEquals(testWeapon.currentBulletCount, y);
        }

        @Test
    public void testNegReload(){
            testWeapon.reload(-100);
            assertEquals(testWeapon.currentBulletCount, y);
            assertTrue(testWeapon.ammoReserve==z);
        }
}

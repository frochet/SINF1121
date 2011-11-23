    

   
    /**
     * Class AVLtree
     */
    public class AvlTree<E>
    {

          /** The tree root. */
        private AvlNode<E> root;
        /**
         * Create a new isntance of the AVLTree
         */
        public AvlTree( )
        {
            root = null;
        }

       /**
        *
        *
        * @param x
        * @param obj
        */
        public void insert( Comparable x,E obj )
        {
            root = insert( x,obj, root );
        }

        /**
         *
         * @param x
         */
        public void remove( Comparable x )
        {
           
        }

       /**
        *
        * @return
        */
        public Comparable findMin( )
        {
            return elementAt( findMin( root ) );
        }

        /**
         *
         * @return
         */
        public Comparable findMax( )
        {
            return elementAt( findMax( root ) );
        }

       /**
        *
        * @param x
        * @return
        */
        public Comparable find( Comparable x )
        {
            return elementAt( find( x, root ) );
        }

       

        /**
         *
         * @return
         */
        public boolean isEmpty( )
        {
            return root == null;
        }

       /**
        *
        */
        public void printTree( )
        {
            if( isEmpty( ) )
                System.out.println( "Tree Empty" );
            else
                printTree( root );
        }

       /**
        *
        * @param t
        * @return
        */
        private Comparable elementAt( AvlNode t )
        {
            return t == null ? null : t.getElement();
        }

        /**
         *
         * @param x
         * @param obj
         * @param t
         * @return
         */
        private AvlNode insert( Comparable x,E obj, AvlNode t )
        {
            if( t == null )
                t = new AvlNode( x,obj, null, null );
            else if( x.compareTo( t.getElement() ) < 0 )
            {
                t.setLeft(insert( x,obj, t.getLeft() ));
                if( height( t.getLeft() ) - height( t.getRight() ) == 2 )
                    if( x.compareTo( t.getLeft().getElement() ) < 0 )
                        t = rotateWithLeftChild( t );
                    else
                        t = doubleWithLeftChild( t );
            }
            else if( x.compareTo( t.getElement() ) > 0 )
            {
                t.setRight(insert( x,obj, t.getRight() ));
                if( height( t.getRight() ) - height( t.getLeft() ) == 2 )
                    if( x.compareTo( t.getRight().getElement() ) > 0 )
                        t = rotateWithRightChild( t );
                    else
                        t = doubleWithRightChild( t );
            }
            else
                ;  // Duplicate; do nothing
            t.setHeight( max( height( t.getLeft() ), height( t.getRight() ) ) + 1);
            return t;
        }

        /**
         *
         * @param t
         * @return
         */
        private AvlNode findMin( AvlNode t )
        {
            if( t == null )
                return t;

            while( t.getLeft() != null )
                t = t.getLeft();
            return t;
        }

        /**
         *
         * @param t
         * @return
         */
        private AvlNode findMax( AvlNode t )
        {
            if( t == null )
                return t;

            while( t.getRight() != null )
                t = t.getRight();
            return t;
        }

        /**
         *
         * @param x
         * @param t
         * @return
         */
        private AvlNode find( Comparable x, AvlNode t )
        {
            while( t != null )
                if( x.compareTo( t.getElement() ) < 0 )
                    t = t.getLeft();
                else if( x.compareTo( t.getElement() ) > 0 )
                    t = t.getRight();
                else
                    return t;    // Match

            return null;   // No match
        }

        /**
         *
         * @param t
         */
        private void printTree( AvlNode t )
        {
            if( t != null )
            {
                printTree( t.getLeft() );
                System.out.println( t.getObject() );
                printTree( t.getRight() );
            }
        }

        /**
         * Return the height of node t, or -1, if null.
         */
        private static int height( AvlNode t )
        {
            return t == null ? -1 : t.getHeight();
        }

        /**
         * Return maximum of lhs and rhs.
         */
        private static int max( int lhs, int rhs )
        {
            return lhs > rhs ? lhs : rhs;
        }

      /**
       *
       * @param k2
       * @return
       */
        private static AvlNode rotateWithLeftChild( AvlNode k2 )
        {
            AvlNode k1 = k2.getLeft();
            k2.setLeft(k1.getRight());
            k1.setRight(k2);
            k2.setHeight( max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1);
            k1.setHeight(max( height( k1.getLeft() ), k2.getHeight() ) + 1);
            return k1;
        }

        /**
         *
         * @param k1
         * @return
         */
        private static AvlNode rotateWithRightChild( AvlNode k1 )
        {
            AvlNode k2 = k1.getRight();
            k1.setRight( k2.getLeft());
            k2.setLeft( k1);
            k1.setHeight( max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1);
            k2.setHeight( max( height( k2.getRight() ), k1.getHeight() ) + 1);
            return k2;
        }

        /**
         *
         * @param k3
         * @return
         */
        private static AvlNode doubleWithLeftChild( AvlNode k3 )
        {
            k3.setLeft(rotateWithRightChild( k3.getLeft() ));
            return rotateWithLeftChild( k3 );
        }

        /**
         *
         * @param k1
         * @return
         */
        private static AvlNode doubleWithRightChild( AvlNode k1 )
        {
            k1.setRight(rotateWithLeftChild( k1.getRight() ));
            return rotateWithRightChild( k1 );
        }



           
   
}
